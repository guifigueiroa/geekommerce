<g:if test="${box}">
<div class="thumbnail">
    <div class="row">
        <div class="col-sm-8 crop">
            <geek:image obj="${box}" />
        </div>
        <div class="col-sm-4 caption">
            <h3><%= box.name %></h3>
            <p>
                <a href="http://${box.url}">
                    http://<%= box.url %>
                </a>
            </p>
            <p>
                <b><g:message code="mysteryBox.minPrice" />: </b>
                R$ <g:formatNumber number="${box.minPrice}" minFractionDigits="2" />
                <g:if test="${box.freight}">
                    + frete
                </g:if>
            </p>
            <p>
                <b><g:message code="mysteryBox.defaultProducts" />: </b>
                <%= box.defaultProducts %>
            </p>
            <p>
                <a href="${createLink(action: 'show', id: box.id)}" class="btn btn-default" role="button">
                    <g:message code="mysteryBox.moreDetails" />
                </a>
            </p>
        </div>
    </div>
</div>
</g:if>
