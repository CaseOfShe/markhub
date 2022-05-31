<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>扫码进行登录验证</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
    <script src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>

<body class="text-center">

<main class="form-signin">
    <form>
        <img class="mb-4"
             src="/images/tou.png"
             alt="" width="72" height="72"  style="border-radius: 15%;">
        <h1 class="h3 mb-3 fw-normal">高档收藏夹</h1>

        <img src="/images/defa.jpg" alt="公众号：一字先生">
        <div class="mt-2 mb-2 text-muted">
            登录验证码：
            <strong style="background-color: yellow; padding: 2px; font-size: 18px;" id="qrcodeeeee">
                ${code}
            </strong>
        </div>
        <p class="text-muted">扫码关注，开启船新体验</p>
    </form>
</main>

<script>

    var dingshi = setInterval(function () {
        console.log("11111111111111111111");
        $.get('/login-check', {
            code: '${code}',
            ticket: '${ticket}'
        }, function (res) {
            console.log(res)
            if (res.code == 0) {
                location.href = "/";
            }
        })
    }, 3000);

    setTimeout(function () {
        clearInterval(dingshi);
        $("#qrcodeeeee").text("验证码过期，请刷新！");
    }, 180000)

</script>

</body>

</body>
</html>