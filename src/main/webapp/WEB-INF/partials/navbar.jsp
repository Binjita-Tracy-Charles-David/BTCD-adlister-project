<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">

<%--TODO:Show different links on navbar depending on whether or not user is logged in--%>

            <li><a href="${profile}">${viewProfile}</a></li>
            <li><a href="${create}">${createAd}</a></li>
            <li><a href="/login">Login</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
    </div>
    </div>
</nav>
