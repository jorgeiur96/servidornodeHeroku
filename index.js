const express 	  = require('express')
var   app 		  = express();
const path 		  = require('path');
const PORT 		  = process.env.PORT || 5000;
var   bodyParser  = require("body-parser"); 

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));


var admin         = require('firebase-admin');



admin.initializeApp({
   credential: admin.credential.cert({
    projectId: 'ejemplofirebase-fd747',
    clientEmail: 'firebase-adminsdk-62t6r@ejemplofirebase-fd747.iam.gserviceaccount.com',
    privateKey: '-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCa6ESvGNUwM+4C\n8BNpwlI/Ielwo+n/Zb8jYymoXzb+0DNYzmaLSjz+rmXHVsevlPJquwuTpSQqQsHQ\njNPqjROp0a4hTHmjhAYt8pWzWTRzvl/ia5ZN24Q/Y+usi2w4FV5VKsFQKvkUhvGh\n9ZCIAQSVSmvrXGwfJ6unWOKfvknghhotbVlFHrKE0Ny+wV2N26k26mysHrpXr3pE\nvydz3hbieUTsnVoxNJadNsU+siv0g9MLxWn53ja7EmWv6FlVjGyp5/TT+90JH5Eb\nAO/b43u69k4ihNJnqHmf8haMuDdMSnJH3gGH+hRgqJ6AF/ZkrLsiQOTD/Pv8RBEr\nDNyN/qeLAgMBAAECggEAKdKX6KZNuKvskMJ8m0sppX3kZtL6dEfmKQm2z4yVboqL\nsmhXazfp6+Dt/bnCQ/d007gYUg5+CyLm7QV4mZTpQCoqVzcsiCc2++TI4hktfiph\n/OGLPQ4NUIgLsxQZbbLnOxtGAfz4LsCYMF/6W53avOvQ40SatHajc5Ud6n8XtxRS\nHMsjAaLXJvLJlQ6zvjGu8xyAvyZ5Fc2zkIYF68IIy0byBrMFnAmn0XqonZvBEPrg\n4wP50XruIk8KwR71VYFnWW1aKTlkwsvdneXOF5LyQu/fIgNNmmUizhQEARjdapFT\nFkHqi0lhYsW6UG4aXuvbJO6CSzUjmzt4boIRTi/swQKBgQDNMsSO9fasQVL1jknD\nYFddUJqPQ0O97StxXxfTsPQo2Jbrr3W/3SXNPkbWpMMKWYgxi4Cb2srPqYuBpx+e\nzfKefFs0NpJmnTHWErqjcmSsLN+ghlsWUx/REJPplVtRoPwTojL/A/QqsZgs59GZ\nmh5TY7URR6bDkeBM5oGWf3rvEQKBgQDBQh00Q1LWwNDp8MYujO2jIZxJsclNbxOK\nENUn7Qu4MrAu2i1bUY0JvOL/AR2ms7ltKB26oEt1Orccv0o2V3gNn5PvQID1iUo7\n8n5vZ7cYKHZP1DTaEAm5538EaQqQ1gFna8B4ERbF4ymaRu2/a6RHurPin55RaUZJ\nDpl0hlnk2wKBgBVOgTRq+8sVGV0gAi7EUS4CUZownNcaylkCS8ISbLfVDY65cFuU\nxfkSz144S3xGoaqrVpZYWJjJfQ/gX5sovVmRhhLc28TF68fTuAeCuEtceXf8m3as\n+O/HbeRiOtI2Charz+nE6lSIjkmTZKMzapS0FLgPnZRPEGBLywbqg8RRAoGBAIsQ\nfyFXfKmqD+r3ZjSjFnE3w1XISBmfX0kPecMEMVW3q83bE55NnZavRAzJicOmOj0R\nC+t6YzIVMSTPhaB66pmrBfG40dNdmnxur4qM8FTC8PfatLlhpw4ORfkvePnl9Rat\nk88SRPfa0doBRh1jYNB4ye6+e1cL0RbLGaOe9drXAoGAKvtYwidOamOQO1XJc/A2\nDgTwZVEK4MDQMLWkv5ZDVrJisJuXgWbHkAwDKGK9tMSz903XHPoFbRYIBYkZ2UrU\nBL5JxUr1EI5PN/7yo42iIC626dciWi461NF9cw42mHdHu0RNS2AQ/9pXmvRfMwCV\nOagUn02BWXtHandoxVmE9RE=\n-----END PRIVATE KEY-----\n'
  }),
  databaseURL: 'https://ejemplofirebase-fd747.firebaseio.com/'
});


  app.use(express.static(path.join(__dirname, 'public')));
  app.set('views', path.join(__dirname, 'views'));
  app.set('view engine', 'ejs');
  app.get('/', (req, res) => res.render('pages/index'));
  


  var tokenDevicesURI   = "/registrar-usuario";

  app.post('/registrar-usuario', function(req, res) {
  	/*optional stuff to do after success */

  	var id_dispositivo 			= req.body.id_dispositivo;
  	var id_usuario_instagram   	= req.body.id_usuario_instagram;
  	var db 						= admin.database();
  	var TokenDevices 			= db.ref(tokenDevicesURI).push();
    TokenDevices.set({
    	id_dispositivo: id_dispositivo,
    	id_usuario_instagram:id_usuario_instagram

    });
  	var path 			= TokenDevices.toString();
	var pathSplit 		= path.split(tokenDevicesURI+"/");
  	var idAutoGenerado  = pathSplit[1];  	
  	var respuesta 		= generarRespuestaAToken(db,idAutoGenerado);
  	
  	res.setHeader("Content-Type","application/json");
  	res.send(JSON.stringify(respuesta));
  });



  function generarRespuestaAToken(db,idAutoGenerado){
  		 var respuesta 	= {};
  		 var  usuario 	= "";
  		 var ref 		= db.ref(tokenDevicesURI);
  		 ref.on("child_added", function(snapshot,prevChildKey){
  		 	 usuario 	= snapshot.val();

  		 	 respuesta 	= {
  		 	 	id:idAutoGenerado,
  		 	 	id_dispositivo: usuario.id_dispositivo,
  		 	 	id_usuario_instagram:usuario.id_usuario_instagram
  		 	 };
  		 })
  		 return respuesta;

  }

  app.listen(PORT, () => console.log(`Listening on ${ PORT }`));
