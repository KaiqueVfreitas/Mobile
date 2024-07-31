import 'package:aula01/aula01.dart' as aula01;

//nao é necessário que o método esteja em uma classe
void main() {
  String nome = "fenando";
  //var não significa que o tipo podera ser alterado
  //se foi decalarada String, sempre sera uma String

  List<String> nomes=["dandan", "nicuzinho", "fernando"];

  var nomeVar = "fenando";
  // o $ é a interpolação de texto e variavel
  print('Seja bem vindo $nomeVar !!!');
  print(nomes[2]);
  print("djhkkdj"+ nomes[1]);
}

