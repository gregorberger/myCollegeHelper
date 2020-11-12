<!DOCTYPE html>
<html lang="en">
<head>
    <title>My College Helper</title>
    <link rel="stylesheet" href="./css/bootstrap.css">


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <a class="navbar-brand text-light font-weight-bold" href="/">MyCollegeHelper</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#--                <li class="nav-item">-->
            <#--                    <a class="nav-link" href="#">Link</a>-->
            <#--                </li>-->
        </ul>
        <div class="form-inline my-2 my-lg-0">
            <a class="btn text-light btn-outline-secondary my-2 my-sm-0" href="/logout">Logout</a>
        </div>
    </div>
</nav>

<div id="mainContainer" class="container">
    <p class="font-weight-bold">Welcome ${userName}</p>

    <div class="mt-4">
        <iframe src="https://calendar.google.com/calendar/embed?height=600&amp;wkst=2&amp;bgcolor=%23ffffff&amp;ctz=Europe%2FBelgrade&amp;src=Z3JlZ29yYmVyZ2VyMTk5NzJAZ21haWwuY29t&amp;color=%23039BE5&amp;title=Calendar" width="100%" height="600" frameborder="0" scrolling="no"></iframe>
    </div>
    <form id="foo">
        <button type="submit">Press me!</button>
    </form>
</div>
<script src="js/jquery-3.5.1.js"></script>
<script src="js/main.js"></script>
</body>
</html>