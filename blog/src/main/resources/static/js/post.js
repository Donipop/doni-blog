function createPost(){
    const content_title = document.getElementById('content-title');
    let title = content_title.value;
    let mark = convertContent();//$('#summernote').summernote('code');//
    sendPost({title: title, content: mark});
}
function updatePost(id){
    console.log("업데이트 post 진입!!!!!");
    const content_title = document.getElementById('content-title');
    let title = content_title.value;
    let mark = convertContent();//$('#summernote').summernote('code');//
    sendUpdatePost({title: title, content: mark, id: id});
}
function sendUpdatePost(parm){
    let form = document.createElement("form");
    form.setAttribute("method","POST");
    form.setAttribute("action","/post?contentid=" + parm.id);
    form.setAttribute("onsubmit","return false;");

    for(const key in parm){
        let hidden = document.createElement("input");
        hidden.setAttribute("type","hidden");
        hidden.setAttribute("name",key);
        hidden.setAttribute("value",parm[key]);
        form.appendChild(hidden);
        /*
        //이렇게도 가능
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
function sendPost(parm){
    let form = document.createElement("form");
    form.setAttribute("method","POST");
    form.setAttribute("action","/post");
    form.setAttribute("onsubmit","return false;");

    for(const key in parm){
        let hidden = document.createElement("input");
        hidden.setAttribute("type","hidden");
        hidden.setAttribute("name",key);
        hidden.setAttribute("value",parm[key]);
        form.appendChild(hidden);
        /*
        //이렇게도 가능
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
    let content = $('#summernote').summernote('code');
    let imgcount = content.split('src="data:image/').length -1;
    let str = content;
    for(let i=1; i<=imgcount; i++){
        //이미지base64값 가져오기 base64img_1[0] = base64이미지값
        let base64img_0 = content.split(';base64,');
        let base64img_1 = base64img_0[i].split('" data-filename=\"');
        //<img style = ~~~~~ ">기준으로 파싱
        let content_split0 = content.split('<img src=');
        let content_split1 = content_split0[i].split('\">');

        //img파일내용을 object로 변경[서버는 json형태로 받음]
        let imgjson = new Object();
        imgjson.name = (base64img_1[1].split("."))[0];
        imgjson.extension = ((content_split0[i].split("data:image/"))[1].split(";"))[0];
        imgjson.width = ((content_split0[i].split('width: '))[1].split(';\"'))[0];

        //이미지가 원래크기와 같지않다면 style태그가 붙어서 그걸 떼줌
        if(base64img_1[0].split("\" style=").length -1 > 0){
            imgjson.base64 = (base64img_1[0].split("\" style="))[0];
        }else{
            imgjson.base64 = base64img_1[0];
        }

        //object - > json 변환
        let imgsrc = sendImageServer(JSON.stringify(imgjson));
        //위에 파싱된 데이터기준으로 replace를 이용해 <img src=base64이미지값"> 을 <img src="주소"> 형태로 변경
        if(base64img_1[0].split("\" style=").length -1 > 0){
            let style0 = (base64img_1[0].split("\" style="))[1];
            str = str.replace('<img src=' + content_split1[0] + '\">',"<img src=\"" + imgsrc.trim() + "\" style=" + style0 + "\">");
        }else{
            str = str.replace('<img src=' + content_split1[0] + '\">',"<img src=\"" + imgsrc.trim() +"\">");
        }


    }
    return str;
}
function sendImageServer(imgjson){
    var result;
    $.ajax({
        type: "post",
        url: "/imageupload",
        data: imgjson,
        async: false,
        headers: {
            'Accept': '*/*',
            'Content-Type': 'application/json'
        },
        success : function (data){
            //console.log(data);
            result = data;
        },
        error : function(e){
            console.log("post.js오류!!" + e)
        }
    });
    return result;
}