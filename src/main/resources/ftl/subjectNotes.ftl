<!DOCTYPE html>
<html lang="en">
<head>
    <title>My College Helper</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/main.css">


</head>
<body>
<nav class="site-header sticky-top py-1 bg-dark pb-2 border-bottom">
    <div class="container d-flex text-light flex-column flex-md-row justify-content-between">
        <a class="navbar-brand text-light font-weight-bold" href="/">MyCollegeHelper</a>

        <a class="btn text-light btn-outline-secondary my-2 my-sm-0" href="/logout">Logout</a>
    </div>
</nav>

<div id="mainContainer" class="position-relative overflow-hidden bg-main container-fluid h-100 w-100">

    <div id="subjectName" class="text-center font-weight-bold text-secondary h2 mt-3">Subject ${subjectName}</div>


    <div class="row">
        <div class="col-sm-3">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item mt-2">
                        <a id="grades" class="nav-link text-center border bg-dark text-white mb-5">
                            Total grade: <#if totalGrade??>${totalGrade} <#else > 0</#if>
                        </a>
                    </li>
                    <#if notesList??>
                        <#list notesList as note>
                            <li class="nav-item mt-2">
                                <a id="${note.id}" class="nav-link active text-center border" onclick="loadNote(${note.id})" style="background-image: url(https://static.tumblr.com/maopbtg/E9Bmgtoht/lines.png), url(https://static.tumblr.com/maopbtg/nBUmgtogx/paper.png) !important;">
                                    ${note.title}
                                </a>
                            </li>
                        </#list>
                    </#if>

                </ul>
            </div>
        </div>
        <div class="col-sm">
            <div class="col-sm-9">
                <div id="wrapper" class="text-center">
                    <form id="paper" method="get" action="">
                        <div id="noteSaved" class="mt-3 text-center alert alert-success collapse" role="alert">
                            Note saved.
                        </div>
                        <div id="margin">Title: <input id="title" type="text" name="title"></div>
                        <textarea placeholder="Enter your first notes." id="textBg" name="text" rows="50" style="overflow: hidden; word-wrap: break-word; resize: none; height: 700px; "></textarea>
                        <input id="button" type="submit" value="Save">

                    </form>



                </div>
            </div>
        </div>
    </div>

</div>

<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/main.js"></script>
</body>
</html>