<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal Favoritos -->
<div class="modal fade" id="modalfavoritos" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">Adicionar aos Favoritos</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form>
	      <div class="modal-body">
	      	<span>Quais tamanhos você deseja adicionar?</span>
	      	<div class="card d-block mx-auto" style="width: 90%">
	      		<div class="ml-3 mt-4 custom-control custom-checkbox">
		      		<input type="checkbox" id="select" class="custom-control-input d-inline-block" onclick="selectAll()">
		      		<label class="custom-control-label" for="select">Selecionar todos</label>
		      	</div>
		        <div class="text-center mt-4">
		        	<c:forEach var="tamanho" items="${lista_tamanho}">
			        	<c:forEach var="referenciap" items="${lista_produto}">
			        		<c:if test="${referenciap.referencia eq tamanho.referencia}">
			        			<label>
									<input type="checkbox" name="idtamanho" class="custom-control-input d-block " value="${tamanho.idproduto}">
									<span class="btn btn-outline-tshirt mr-1">${tamanho.tamanho}</span>
								</label>
			        		</c:if>
			        	</c:forEach>
		        	</c:forEach>
		        </div>
	      	</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary" formaction="Favoritos" formmethod="post">Adicionar</button>
	      </div>
      </form>
    </div>
  </div>
</div>
	