@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_splash);

    // 延迟两秒后跳转到登录界面
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(splashActivity.this, loginActivity.class);
            startActivity(intent);
            finish(); // 关闭当前活动
        }
    }, 2000); // 延迟时间为2000毫秒（2秒）
}