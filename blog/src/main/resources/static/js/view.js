/*window.onload = function (){
    createView();
}*/
function addDiv(title,content,user,hits,timestamp) {

        let div = document.createElement("div");
        div.className="col";
        let field = document.getElementById('colmain');

        let str = '';
        str += '<div class="card shadow-sm">'
        str += `<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">${title}</text></svg>`
        str += '<div class="card-body">'
        str += `<p class="card-text">${content}</p>`
        str += '<div class="d-flex justify-content-between align-items-center">'
        str += '<div class="btn-group">'
        str += '<button type="button" class="btn btn-sm btn-outline-secondary">View</button>'
        str += '<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>'
        str += '</div>'
        str += `<small class="text-muted">${timestamp}</small>`
        str += '</div></div></div></div>'

        div.innerHTML = str;
        field.appendChild(div);
}

function createView(username){
    console.log('create!2');
    //뷰를 가져옴
    let resultjson = getView(username);
    let obj = JSON.parse(resultjson);
    //addDiv(title,content,user,hits,timestamp)
    for(let i = 0; i<obj.length; i++){
        addDiv(obj[i].title,
            obj[i].content,
            obj[i].user,
            obj[i].hits,
            obj[i].timestamp);
    }
}

function getView(username){
    let result;
    if(username === "" || username == null){
        username = "";
    }
    $.ajax({
        type: "get",
        url: "view?username=" + username,
        async: false,
        success: function (data){
            result = data;
        }
    });
    return result;
}