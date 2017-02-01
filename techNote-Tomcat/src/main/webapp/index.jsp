<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>技術報告日記</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/layout.css" rel="stylesheet">
  </head>

  <body>
    <header>
      <div class="container">
        <h1 class="title">技術報告日記</h1>
        <p class="lead title-description">1日の技術開発などを更新するブログ</p>
      </div>
    </header>

    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <img src="./img/another.jpg" class="d-flex aling-self-start mr-3 rounded" alt="user icon" width="100px">
            <p>Name : yamanaka@hikaru</p>
            <p>
                趣味：<br>
                勉強（かなり雑食）、ビリヤード、アニメ鑑賞、考えること、テレビゲーム、ボードゲーム<br>
                補足：<br>
                勉強は童心心に帰ったようになんにでも興味を持つようにしているので、いつの間にかこんなになってましたw
            </p>
            <p>
              今まで学んだ技術：<br>
              【プログラミング言語】<br>
              Java,C,C++,JavaScript,HTML,CSS,Swift,Python3,Scala,Markdown,Ruby<br>
              【データベース】<br>
              MySQL,Oracle,sqlite<br>
              【開発環境】<br>
              eclipse,Atom,terapad,Xcode等<br>
              【フレームワーク】<br>
              jQuery,Resumable.js,Vue.js,Capper.js,Play Framework<br>
              【ツールキット】<br>
              Akka<br>
              【OS】<br>
              windows,Mac,Linux(Cent6 OS,Cent7 OS,ubuntu)<br>
              【OSS】<br>
              Apache Tomcat,Apache Cordova,Apache Http Server,Apache Lucene,Apache Solr,nginx<br>
              【その他】<br>
              Tex(LaTeX),物理（力学、量子力学、一般相対性理論、熱力学）,数学（解析学、線形代数、集合論）
            </p>
          </div>
        </div>
        <div class="col-sm-7 offset-sm-1">
          <form action="./Search" method="POST">
            <div class="form-group row">
              <div class="col-sm-10">
                <input class="form-control" placeholder="#を先頭に着けてタグをOR検索、＆を先頭につけてAND検索（複数検索は間に空白）。それ以外は文章のタイトルと説明からのワード検索" type="text" name="search">
              </div>
              <div class="col-sm-2">
                <button class="btn btn-outline-success" type="submit">検索</button>
              </div>
            </div>
          </form>
          <hr>
          <c:forEach var="t" items="${todo}">
            <div class="todo-box rounded">
              <h2>${t.title}</h2>
              <div class="todo-description text-justify">
                ${t.description}
              </div>
              <p class="text-right"><small>投稿日時</small>：${t.timestamp}</p>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </body>
</html>
