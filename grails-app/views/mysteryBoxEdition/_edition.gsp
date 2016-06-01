<ul class="list-group">
    <div id="items-${edition.id}">
        <g:each var="item" in="${edition.items}">
        <li class="list-group-item"><%= item.name %> <span class="badge sell-badge">vender</span><span class="badge">2 itens à venda</span></a></li>
        </g:each>
    </div>
    <g:if test="${controllerName == 'mysteryBoxEdition'}">
    <li class="list-group-item">
        <div id="error-${edition.id}" class="error-new-item"></div>
        <div class="row">
            <div class="col-md-8">
                <input type="hidden" id="editionId" value="${edition.id}">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="${message(code: 'mysteryBoxItem.new')}" id="name">
                </div>
            </div>
            <div class="col-md-2">
                <button id="add-box-item" class="btn btn-default"><g:message code="mysteryBoxItem.add" /></button>
            </div>
        </div>
    </li>
    </g:if>
</ul>
