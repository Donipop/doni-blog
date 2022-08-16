function createPost(){
    const content_title = document.getElementById('content-title');
    let title = content_title.value;
    let mark = convertContent();
    sendPost({title: title, content: mark});
}
function sendPost(parm){
    let form = document.createElement("form");
    form.setAttribute("method","POST");
    form.setAttribute("action","/post");

    for(const key in parm){
        let hidden = document.createElement("input");
        hidden.setAttribute("type","hidden");
        hidden.setAttribute("name",key);
        hidden.setAttribute("value",parm[key]);
        form.appendChild(hidden);
        /*
        const formField = document.createElement('input');
        formField.type = 'hidden';
        formField.name = key;
        formField.value = parameters[key];

        form.appendChild(formField);
        */
    }
    document.body.appendChild(form);
    form.submit();

}
function convertContent(){
    let str = "";
    let content = $('#summernote').summernote('code');
    let imgcount = content.split('src="data:image/').length -1;
    //<img style="width: 800px;" src="data:image/png;base64,
    //<img style="width: 445.188px;" src="data:image/jpeg;base64,
    //" data-filename="logo.jpg">
    let base64img_0 = content.split(';base64,');
    let base64img_1 = base64img_0[1].split('" data-filename');
    return str;
}