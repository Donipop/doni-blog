/*window.onload = function (){
    createView();
}*/
function addDiv(title,content,user,hits,timestamp,id) {
        //내용에 <p> <br> <img>등 태그삭제

        let img;
        if(content.split('<img src=').length -1 > 0){
            img = ((content.split('<img src="'))[1].split('"'))[0];
        }else{
            img = 'http://gdimg.gmarket.co.kr/2147431261/still/600?ver=1624429655';
        }
        content = content.replace(/(<([^>]+)>)/gi,"");

        let div = document.createElement("div");
        div.className="col";
        let field = document.getElementById('colmain');

        let str = '';
        str += '<div class="card shadow-sm">'
    //<img class="card-img-top" src="..." alt="Card image cap">
        str += `<img class="card-img-top" width="100%" height="225" src="${img}" alt="Card image cap">`
        str += '<div class="card-body">'
        str += `<h5 class="card-title">${title}</h5>
                <p class="card-text">${content}</p>`
        str += '<div class="d-flex justify-content-between align-items-center">'
        str += '<div class="btn-group">'
        str += '<button type="button" class="btn btn-sm btn-outline-secondary" onclick="viewButton('+ id + ')">View</button>'

        str += '<button type="button" class="btn btn-sm btn-outline-secondary" onclick="editButton('+ id + ')">Edit</button>'
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
            obj[i].timestamp,
            obj[i].id);
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
function editButton(id){
    location.href="/post?contentid=" + id;
}
function viewButton(id){
    location.href="/post?view&contentid=" + id;
}