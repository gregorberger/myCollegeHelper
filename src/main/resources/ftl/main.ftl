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

<#--            <#if !predmeti?has_content>-->
<#--                <form id="vpis_v_ucilnico">-->
<#--                    <label for="ucilnica">Spletna učilnica FRI:</label>-->
<#--                    <label for="ucilnica_mail"></label><input type="text" id="ucilnica_mail" name="mail" placeholder=" Uporabniški email">-->
<#--                    <label for="ucilnica_geslo"></label><input type="password" id="ucilnica_geslo" name="passwd" placeholder=" Geslo">-->
<#--&lt;#&ndash;                    <button class="btn text-light btn-outline-secondary my-2 my-sm-0" type="submit" value="Submit">Prijava</button>&ndash;&gt;-->
<#--                </form>-->
<#--            </#if>-->

            <a class="btn text-light btn-outline-secondary my-2 my-sm-0" href="/logout">Logout</a>
        </div>
    </nav>

    <div id="mainContainer" class="position-relative overflow-hidden text-center bg-main">

    <div class="p-7">
        <iframe src="https://calendar.google.com/calendar/embed?height=600&amp;wkst=2&amp;bgcolor=%23ffffff&amp;ctz=Europe%2FBelgrade&amp;src=bXBzdHVkZW50OTlAZ21haWwuY29t&amp;color=%23039BE5&amp;showNav=1&amp;showDate=1&amp;title=Calendar" style="border-width:0" width="1100" height="600" frameborder="0" scrolling="no"></iframe>
    </div>



    <div class="row gh-1 gv-4 p-7">
        <#if subjects??>
            <#list subjects as x>
                <div class="col-12 col-md-6 col-lg-4 show-on-scroll show-on-scroll-ready mt-3" data-show-duration="500" data-show-distance="20" data-show-delay="50" style="transform: translateY(0px); transition-duration: 500ms; opacity: 1;">
                    <a href="/subject/${x.name}" class="card card-demo bg-dark">
                        <span class="card-img">
                            <img width="550" height="450" src="./images/notes2.png" alt="" style="padding-right: 100px;">
                        </span>
                        <span class="card-body">
                            <span class="card-title h5 text-light-50">${x.name}</span>
                        </span>
                    </a>
                </div>
            </#list>
        </#if>
    </div>
</div>

<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/main.js"></script>
</body>
</html>