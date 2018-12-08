<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <title>T-Shirt Games - Cadastra-se</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.ValidateJuridico.css">

    <script type="text/javascript" src="resources/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="resources/js/script.ValidateJuridico.js"></script>
    <script type="text/javascript" src="resources/js/jquery/jquery.mask.js"></script>
    <script type="text/javascript" src="resources/js/jquery/jquery.cpfcnpj.js"></script>
    <script type="text/javascript" src="resources/js/script.Buscacep.js"></script>
    <script type="text/javascript" src="resources/js/script.Mask.js"></script>
    <script type="text/javascript" src="resources/js/script.UploadImage.js"></script>
</head>

<body>

    <!-- NAV -->
    <c:import url="resources/template/nav.jsp" />
    <section class="container mt-4">
        <div class="col-lg-6 offset-lg-3">
            <h2 class="text-center">Cadastre-se</h2>
            <p class="lead text-center">Venha fazer parte </p>
            <hr>
            <form id="imagetype" enctype="multipart/form-data">
            	<div class="form-group">
            		<label>Logotipo da Empresa:</label>
            		<img src="resources/img/imagens/user.svg" id="visual_image" class="d-block mx-auto mb-3" width="300" height="300" style="border-radius: 50%;">
                    <input type="file" class="form-control" name="image" placeholder="Insira uma Imagem..." onchange="uploadfile()" required>
                </div>
            </form>
            <form id="ValidacaoCampos" accept-charset="ISO-8859-1">
            	<input type="hidden" class="form-control" id="nameimage" name="logo" value="user.svg">
                <div class="form-group">
                    <label for="inputEmail">E-mail:</label>
                    <input type="email" class="form-control" id="conf_email" name="conf_email" placeholder="email@email.com" onchange="form.confirmar_email.pattern = this.value;" required>
                </div>
                <div class="form-group">
                    <label for="inputConfirmesenha">Confirme o E-mail:</label>
                    <input type="email" class="form-control" id="email" name="email" required placeholder="email@email.com">
                </div>
                <div class="form-group">
                    <label for="inputSenha">Senha:</label>
                    <input type="password" class="form-control" id="conf_senha" name="conf_senha" placeholder="Digite sua senha" onchange="form.confirmar_senha.pattern = this.value;" required>
                </div>
                <div class="form-group">
                    <label for="inputConfirmesenha">Confirme a Senha:</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder="Confirme sua senha" required>
                </div>
                <div class="form-group">
                    <label for="inputRazaoso">Razão Social:</label>
                    <input type="text" class="form-control" name="razao" id="razao" placeholder="" required>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputNomefan">Nome Fantasia:</label>
                        <input type="text" class="form-control" name="nomefantasia" id="nomefantasia" placeholder="" required>
                    </div>
                    <div class="form-group col-md-6">
                        <p class="text-center cadastrar_taux"><a href="CadastroFisico.jsp">Não é pessoa Jurídica?</a></p>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCnpj">CNPJ:</label>
                        <input type="text" class="form-control validate" id="cnpj" name="cnpj" placeholder="Digite apenas números" pattern="[0-9]+$" required />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputInscricaoes">Inscrição Estadual:</label>
                        <input type="text" class="form-control" id="ie" name="ie" placeholder="Digite apenas números" pattern="[0-9]+$" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputZip">CEP</label>
                        <input type="text" class="form-control" id="cep" name="cep" placeholder="00000-000" required pattern="\d{5}-?\d{3}" />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputAddress">Endereço</label>
                        <input type="text" class="form-control" name="endereco" id="endereco" placeholder="Ex: Rua das Oliveiras" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="inputAddress">Nº</label>
                        <input type="text" class="form-control" name="numero" id="numero" placeholder="Ex: 2001" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="inputAddress">Comp.</label>
                        <input type="text" class="form-control" name="complemento" id="complemento" placeholder="Ex: Apto 3">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputCidade">Bairro</label>
                        <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Ex: Centro" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCidade">Cidade</label>
                        <input type="text" class="form-control" name="cidade" id="cidade" placeholder="Ex: São Paulo" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Estado</label>
                        <select id="estado" name="estado" class="form-control" required>
                            <option value="" selected>Selecione</option>
                            <option value="Acre">Acre</option>
                            <option value="Alagoas">Alagoas</option>
                            <option value="Amazonas">Amazonas</option>
                            <option value="Amapá">Amapá</option>
                            <option value="Bahia">Bahia</option>
                            <option value="Ceará">Ceará</option>
                            <option value="Distrito Federal">Distrito Federal</option>
                            <option value="Espírito Santo">Espírito Santo</option>
                            <option value="Goiás">Goiás</option>
                            <option value="Maranhão">Maranhão</option>
                            <option value="Minas Gerais">Minas Gerais</option>
                            <option value="Mato Grosso Do Sul">Mato Grosso Do Sul</option>
                            <option value="Mato Grosso">Mato Grosso</option>
                            <option value="Pará">Pará</option>
                            <option value="Paraíba">Paraíba</option>
                            <option value="Pernambuco">Pernambuco</option>
                            <option value="Piauí">Piauí</option>
                            <option value="Paraná">Paraná</option>
                            <option value="Rio De Janeiro">Rio De Janeiro</option>
                            <option value="Rio Grande Do Norte">Rio Grande Do Norte</option>
                            <option value="Rondônia">Rondônia</option>
                            <option value="Roraima">Roraima</option>
                            <option value="Rio Grande Do Sul">Rio Grande Do Sul</option>
                            <option value="Santa Catarina">Santa Catarina</option>
                            <option value="Sergipe">Sergipe</option>
                            <option value="São Paulo">São Paulo</option>
                            <option value="Tocantins">Tocantins</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">Telefone</label>
                        <input type="text" class="form-control telefone" name="telefone" id="telefone" placeholder="Ex: (99) 9999-9999">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputCity">Celular</label>
                        <input type="text" class="form-control celular" name="celular" id="celular" placeholder="Ex: (99) 99999-9999" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4,5}" required>
                    </div>
                </div>
                <br>
                <button id="cadastrar_button" type="submit" class="btn btn-lg btn-block btn-tshirt" formaction="CadastroJuridico" formmethod="post">Criar seu cadastro</button>
                <p class="text-center cadastrar">Já tem cadastro? <a href="Login.jsp">Entrar</a></p>
            </form>
        </div>
    </section>
    <!-- FOOTER -->
    <c:import url="resources/template/footer.jsp" />
    <c:import url="resources/template/modal.Mensagem.jsp" />
</body>

</html>