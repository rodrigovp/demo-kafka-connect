CONTAINER_NAME="criador-topicos"

remove_container() {
  echo "Removendo conteiner $CONTAINER_NAME..."
  docker rm $CONTAINER_NAME
}

criar_atualizar_conectores(){
  echo "Instalando conectores no kafka connect..."

  cd cdc-kafka-connect

  echo "\nInstalando conector do autorizador..."
  ./autorizador-conector.sh

  echo "\nInstalando conector do datalake..."
  ./datalake-conector.sh

  cd ..
}

echo "Subindo a infra da aplicação..."
docker-compose up -d

while true; do
  if ! docker ps -f "name=$CONTAINER_NAME" --format "{{.Names}}" | grep -q "$CONTAINER_NAME"; then
    remove_container
    sleep 40
    criar_atualizar_conectores
    break
  fi
  sleep 1
done

