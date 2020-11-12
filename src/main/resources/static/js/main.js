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