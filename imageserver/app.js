const express = require('express');
const fs = require('fs');

const app = express();
const port = 8000;

app.use(express.json({
    limit: "10mb"
}));

//정적파일 가상주소 적용
//http://localhost:8000/img/name.jpeg
app.use('/img', express.static('uploads')); 


app.post('/single/upload', (req,res) => {
    try{
    //console.log(req.body);
    let now = new Date();
    let year = now.getFullYear();
    let month = now.getMonth();
    let date = now.getDate();
    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();

    let name = `${year}-${month}-${date}-${hours}-${minutes}-${seconds}-${req.body.name}`;
    if(saveImage(name,req.body.base64,req.body.extension) == "ok"){
        res.send(`http://localhost:8000/img/${name}.${req.body.extension}`);
    }else{
        res.send("err")
    }
    
    }catch(err){
        res.status(500);
        res.send(err.message);
    }
    //res.json({ok: true, data: "Single Upload Ok"})

});


app.listen(port,() =>{
    console.log(`서버켜짐 ${port}`);
})

function saveImage(name,base64,extension){
    let binaryData = new Buffer.from(base64,'base64').toString('binary');
    
    console.log(`${__dirname}/uploads/${name}.${extension}저장`);

    fs.writeFile(`${__dirname}/uploads/${name}.${extension}`,binaryData,'binary',function(err){
        //console.log(err);
        return err;
    })
    return "ok";
}