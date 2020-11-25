$(function() {
    $("#vpis_v_ucilnico").submit(function(e) {

        var userName = document.getElementById("ucilnica_mail").value;
        var password = document.getElementById("ucilnica_geslo").value;

        var data = {
            "userName": userName,
            "password": password
        };

        //prevent Default functionality
        e.preventDefault();

        //do your own request an handle the results
        $.ajax({
            url: "/getVpis",
            type: 'get',
            dataType: 'json',
            data: data,
            success: function(data) {
                console.log("rr");
                location.reload();
            }
        });
    });
});



$(function() {
    $("#paper").submit(function(e) {

        var title = document.getElementById("title").value;
        var textBg = document.getElementById("textBg").value;
        var subjectName = document.getElementById("subjectName").textContent.replace("Subject ", "");

        //prevent Default functionality
        e.preventDefault();

        if (title === "" || textBg === "") {
            console.log("prazni vnos");
            return;
        }


        var data = {
            "title": title,
            "noteText": textBg,
            "subjectName": subjectName
        };

        //do your own request an handle the results
        $.ajax({
            url: "/subject/insertNote",
            type: 'get',
            dataType: 'json',
            data: data,
            success: function(data) {
                let element = document.getElementById("noteSaved");
                element.classList.remove("collapse");
                setTimeout(function(){
                    element.classList.add("collapse");
                }, 2000);
            }
        });

    });

});

function loadNote(noteId) {
    var data = {
        "noteId": noteId
    };

    //do your own request an handle the results
    $.ajax({
        url: "/subject/loadNote",
        type: 'get',
        dataType: 'json',
        data: data,
        success: function(data) {
            document.getElementById("title").value = data.title;
            document.getElementById("textBg").value = data.notes;
        }
    });
}