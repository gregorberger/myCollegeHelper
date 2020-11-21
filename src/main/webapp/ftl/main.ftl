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

    <div class="p-7">
        <iframe src="https://calendar.google.com/calendar/embed?height=900&amp;wkst=2&amp;bgcolor=%23343a40&amp;ctz=Europe%2FBelgrade&amp;src=Z3JlZ29yYmVyZ2VyMTk5NzJAZ21haWwuY29t&amp;color=%23039BE5&amp;title=Calendar" width="100%" height="600" frameborder="0" scrolling="no"></iframe>
    </div>
    <form id="foo">
        <button class="btn btn-outline-secondary" type="submit">Press me!</button>
    </form>



    <div class="row gh-1 gv-4 p-7">
<#--        TODO: ces vse predmete in names ${x} ime predmeta in se v vrstici 40 da se prikaze ime predmeta (ce se ni prijavlen in ni predmetov ne kazat)-->
        <#list 1..6 as x>
            <div class="col-12 col-md-6 col-lg-4 show-on-scroll show-on-scroll-ready mt-3" data-show-duration="500" data-show-distance="20" data-show-delay="50" style="transform: translateY(0px); transition-duration: 500ms; opacity: 1;">
                <a href="/subject/Informacijski sistemi" class="card card-demo bg-dark">
                    <span class="card-img">
                        <img width="550" height="450" src="./images/notes2.png" alt="" style="padding-right: 100px;">
                    </span>
                    <span class="card-body">
                        <span class="card-title h5 text-black-50">Predmet</span>
                    </span>
                </a>
            </div>
        </#list>
    </div>
</div>

<script src="js/jquery-3.5.1.js"></script>
<script src="js/main.js"></script>
</body>
</html>