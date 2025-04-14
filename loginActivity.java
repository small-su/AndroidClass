@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.layout__login);

    // 添加注册按钮点击事件
    Button registerButton = findViewById(R.id.button);
    registerButton.setEnabled(true); // 确保按钮可点击
    registerButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(loginActivity.this, signActivity.class);
            startActivity(intent);
        }
    });
}