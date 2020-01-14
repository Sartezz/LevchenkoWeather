package com.example.utils

import com.example.data.db.entity.WeatherInfoDb
import com.example.data.rest.entity.WeatherInfoResponse
import com.example.domain.entity.WeatherInfo

fun WeatherInfoResponse.transformToWeatherInfo() = WeatherInfo(
    name,
    dt,
    weather[0].main,
    weather[0].icon,
    main.temp,
    main.tempMin,
    main.tempMax,
    wind.speed,
    wind.deg,
    sys.sunrise,
    sys.sunset,
    main.humidity,
    main.feelsLike
)

fun WeatherInfoDb.transformToWeatherInfo() = WeatherInfo(
    name,
    dt,
    main,
    icon,
    temp,
    tempMin,
    tempMax,
    windSpeed,
    windDeg,
    sunrise,
    sunset,
    humidity,
    feelsLike
)

fun WeatherInfo.transformToWeatherInfoDb() = WeatherInfoDb(
    null,
    name,
    dt,
    main,
    icon,
    temp,
    tempMin,
    tempMax,
    windSpeed,
    windDeg,
    sunrise,
    sunset,
    humidity,
    feelsLike
)