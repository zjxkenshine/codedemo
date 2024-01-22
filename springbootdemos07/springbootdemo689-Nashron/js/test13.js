var SuperRunner = Java.type('com.kenshine.nashron.SuperRunner');
var Runner = Java.extend(SuperRunner);
var runner = new Runner() {
    run: function() {
        Java.super(runner).run();
        print('on my run');
    }
}
runner.run();
