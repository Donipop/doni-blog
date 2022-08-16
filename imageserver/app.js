const express = require('express');
const fs = require('fs');

const app = express();

app.use(express.json());

const port = 8000;


app.post('/single/upload', function(req,res){
    console.log(req.body);
    res.send(req.body);
    //res.json({ok: true, data: "Single Upload Ok"})

});


app.listen(port,() =>{
    console.log(`서버켜짐 ${port}`);
})

convertContent();
function convertContent(){
    let str = "";
    let content = '<img style="width: 800px;" src="data:image/png;base64,123" data-filename="logo.png"> <br> <img style="width: 445.188px;" src="data:image/jpeg;base64,456" data-filename="logo.jpg">';//$('#summernote').summernote('code');
    let imgcount = content.split('src="data:image/').length -1;
    //content.split('src="data:image/').length -1;
    //<img style="width: 800px;" src="data:image/png;base64,
    //<img style="width: 445.188px;" src="data:image/jpeg;base64,
    //" data-filename="logo.jpg">
    
    for(let i=1; i<=imgcount; i++){
        let base64img_0 = content.split(';base64,');
        let base64img_1 = base64img_0[i].split('" data-filename');
        console.log(base64img_1[0]);
    }

    fs.writeFileSync("aa.jpg",data);
    
    
}