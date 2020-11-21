// Bind to the submit event of our form
$("#foo").submit(function(event){

    // Prevent default posting of form - put here to work in case of errors
    event.preventDefault();

    // Fire off the request
    request = $.ajax({
        url: "/getEvents",
        type: "get",
    });

    // Callback handler that will be called on success
    // request.done(function (response, textStatus, jqXHR){
    //     // Log a message to the console
    //     console.log("Hooray, it worked!");
    // });

    // Callback handler that will be called on failure
    // request.fail(function (jqXHR, textStatus, errorThrown){
    //     // Log the error to the console
    //     console.error(
    //         "The following error occurred: "+
    //         textStatus, errorThrown
    //     );
    // });

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