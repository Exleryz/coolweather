# coolweather
  2017.12.19 按照原书上的代码，选择好县1，显示天气，再选择一个县2，显示天气，并且是保存县2天气，但是下拉刷新时显示的是县1的天气
  
  分析原因 :
  
  swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestWeather(weatherId);
            }
        });
	下拉刷新使用的是weatherId,而不是直接读取服务器返回在本地的县2的数据
	并且 仅 在onCreate()方法中进行过weatherId的赋值，还是在没有缓存的时候
	if (weatherString != null) {    // 有缓存时直接解析天气数据
        Weather weather = Utility.handleWeatherResponse(weatherString);    // 解析本地weatherString
        weatherId = weather.basic.weatherId;
        showWeatherInfo(weather);
    } else {    // 无缓存时去服务器查询天气
        weatherId= getIntent().getStringExtra("weather_id");
        weatherLayout.setVisibility(View.INVISIBLE);
        requestWeather(weatherId);
    }
	
	所以在我们刷新县2天气的时候weatherId一直没有发生过变化一直都是县1的
	当重新打开应用显示的是县2的天气内容，因为存在缓存解析出了县2的weatherId
	
	解决方法 :
	
	weatherId等级提升(设置为变量)，并且需要在某个地方改变weatherId才行
	
	    1.requestWeather()查询成功的时候
		2.showWeatherInfo(weather)函数里
		    weatherId = weather.basic.weatherId;