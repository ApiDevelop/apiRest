# API tests with Java architecture

## Introduction
    Este é um repositório para aprender um pouco mais sobre APIs REST com arqitetura em Java.
    O conhecimento e estudo será em cima da construção de uma API para um serviço de Streaming.

## Response List
    200 - response
    201 - Created
    202 - request successful - proccess  solicitação realidada com sucesso, mas a ação sera realizada em outro momento 
    204 - No Content - return not necessary
    400 - Bad Request
    401 - Unauthorized
    403 - Forbidden
    404 - Not Find
    409 - Conflict
    422 - Unprocessable Entity

## API Structure - Post
    Requisição => Controller > Services > Repository > Entity

### Controller
    Intercepta a request, ñ tem regra de negócio e irá chamar a camada de serviço.
    - @RequestMapping (value e method)
    - @RequestBody
    - @RequestHeader
    - @ApiOperation

### Services
    Regras de negócio, ñ acessar DB e chama camada de repositório.

### Respository
    Acessa DB, ñ tem regra de negócio e faz uso de entidades.

### Entity
    Representa uma tabela no DB

## API Structure - Response
    Return => Reository > Service > Controller