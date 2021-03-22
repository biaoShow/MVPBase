package com.dmai.carreveal.model.http;

import com.dmai.carreveal.model.bean.BaseBean;
import com.dmai.carreveal.model.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created on 2019/4/10.
 */

public interface ApiService {

    @POST("login")
    Observable<BaseBean<LoginBean>> login(@QueryMap Map<String, String> map);
//    @GET("api/lyric/{songname}")
//    Observable<SongNameGetLyrics> getLyricsUrl(@Path("songname") String songName);//根据歌名获取歌词URL
//
//    @GET("v1/restserver/ting")
//    Observable<LyricsBean> getLyrics(@QueryMap Map<String, String> map);
//
//    @GET("v1/restserver/ting")
//    Observable<MusciBean> getMusciDetails(@QueryMap Map<String, String> map);
//
//    @GET("/s6/weather/now")
//    Observable<WeatherNow> getNowWeather(@QueryMap Map<String, String> map);//获取now天气
//
//    @GET("/s6/weather/forecast")
//    Observable<LaterWeather> getFutureWeather(@QueryMap Map<String, String> map);//获取未来天气
//
//    /**
//     * 下载歌词（歌词迷）
//     *
//     * @param fileUrl
//     * @return
//     */
//    @Streaming //大文件时要加不然会OOM
//    @GET
//    Observable<ResponseBody> downloadFile(@Url String fileUrl);
}
