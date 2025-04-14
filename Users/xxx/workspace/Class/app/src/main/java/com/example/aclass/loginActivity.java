Button loginButton = findViewById(R.id.login_button); // 假设登录按钮的id为login_button
loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(loginActivity.this, ArtifactCategoryActivity.class);
        startActivity(intent);
    }
});