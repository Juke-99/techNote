<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>技術報告日記 | 入力画面</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/layout.css" rel="stylesheet">
  </head>

  <body>
    <header>
      <div class="container">
        <h1 class="title">技術報告日記</h1>
        <p class="lead title-description">1日の技術開発などを更新するブログ</p>
      </div>
    </header>

    <div class="container">
      <form action="../myresource/MyResource" method="POST">
        <div class="form-group">
          <label>タイトル：</label>
          <input type="text" class="form-control" placeholder="なんの技術についての記事か？" name="title">
        </div>
        <div class="form-group">
          <label>タグ：</label>
          <input type="text" class="form-control" placeholder="タイトルもしくは記事に関連する。複数個記述する場合は空白を開けて区切ってください。" name="tags">
        </div>
        <div class="form-group">
          <label>内容：</label>
          <textarea class="form-control" rows="5" placeholder="タイトルの内容となる記事を書いてください。" name="description"></textarea>
        </div>
        <input type="submit" class="btn btn-default" value="送信">
      </form>
    </div>
  </body>
</html>
