<!DOCTYPE html>
<html lang="en">
<head>
    <title>My College Helper</title>
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/main.css">


</head>
<body>
<nav class="site-header sticky-top py-1 bg-dark pb-2 border-bottom">
    <div class="container d-flex text-light flex-column flex-md-row justify-content-between">
        <a class="navbar-brand text-light font-weight-bold" href="/">MyCollegeHelper</a>

        <a class="btn text-light btn-outline-secondary my-2 my-sm-0" href="/logout">Logout</a>
    </div>
</nav>

<div id="mainContainer" class="position-relative overflow-hidden text-center bg-main">
    <h1 class="display-4 font-weight-normal mt-2 text-light">Welcome ${userName}</h1>

    <div class="p-7">
        <iframe src="https://calendar.google.com/calendar/embed?height=900&amp;wkst=2&amp;bgcolor=%23343a40&amp;ctz=Europe%2FBelgrade&amp;src=Z3JlZ29yYmVyZ2VyMTk5NzJAZ21haWwuY29t&amp;color=%23039BE5&amp;title=Calendar" width="100%" height="600" frameborder="0" scrolling="no"></iframe>
    </div>
    <form id="foo">
        <button class="btn btn-outline-secondary" type="submit">Press me!</button>
    </form>
</div>

<script src="js/jquery-3.5.1.js"></script>
<script src="js/main.js"></script>
</body>
</html>