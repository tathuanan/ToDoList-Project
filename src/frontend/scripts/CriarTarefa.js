var hoje = new Date();

var dd = String(hoje.getDate()).padStart(2, '0');
var mm = String(hoje.getMonth() +1).padStart(2, '0');
var aaaa = hoje.getFullYear();

hoje = aaaa + '-' + mm + '-' + dd;

document.getElementById('createDate').value = hoje;
document.getElementById('deadLine').value = hoje