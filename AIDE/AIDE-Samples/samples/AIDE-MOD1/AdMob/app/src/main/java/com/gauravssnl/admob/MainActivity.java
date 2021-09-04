package com.gauravssnl.admob;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity {
    private AdView adView;
    private RewardedVideoAd mRewardedVideoAd;
    private InterstitialAd mInterstitialAd;
    private LinearLayout adsBanners;
    private Button adsInterestitials;
    private Button adsReward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
	Toolbar toolbar = findViewById(R.id.toolbar);
	setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View pr) {
               onBackPressed();
            }
        });
        
	adsBanners = findViewById(R.id.adsBanners);
	adsInterestitials = findViewById(R.id.adsInterestitials);
        adsReward = findViewById(R.id.adsReward);
        
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713"); 
        
        setBanners();
        setInterestitials();
        setReward();
        
        adsInterestitials.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (mInterstitialAd.isLoaded()) { 
                    mInterstitialAd.show();
		}
            }
        });
        adsReward.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (mRewardedVideoAd.isLoaded()) {  
                    mRewardedVideoAd.show();  
                } else {
                    loadRewardedVideoAd();
                }
            }
        });
    }
    
    //Banners
    public void setBanners(){
        adView = new AdView(this); 
        adView.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT)); 
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        AdRequest adRequest = new AdRequest.Builder().build(); 
        adView.loadAd(adRequest); 
        adView.setAdListener(new AdListener() {
            @Override public void onAdLoaded() {}
            @Override public void onAdFailedToLoad(int errorCode) {}
            @Override public void onAdOpened() {}
            @Override public void onAdLeftApplication() {}
            @Override public void onAdClosed() {} 
        });
	adsBanners.addView(adView);
    }
    
    //interestitial
    public void setInterestitials(){
        mInterstitialAd = new InterstitialAd(this);  
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); 
        mInterstitialAd.loadAd(new AdRequest.Builder().build()); 
        mInterstitialAd.setAdListener(new AdListener() {
            @Override public void onAdLoaded() {}
            @Override public void onAdFailedToLoad(int errorCode) {}
            @Override public void onAdOpened() {}
            @Override public void onAdLeftApplication() {}
            @Override public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }  
        });
    }

    //Video
    public void setReward(){
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this); 
        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener(){
            @Override public void onRewarded(RewardItem reward) {}
            @Override public void onRewardedVideoAdLeftApplication() {}
            @Override public void onRewardedVideoAdClosed() {
                loadRewardedVideoAd();
            } 
            @Override public void onRewardedVideoAdFailedToLoad(int errorCode) {} 
            @Override public void onRewardedVideoAdLoaded(){}
            @Override public void onRewardedVideoAdOpened() {} 
            @Override public void onRewardedVideoStarted() {} 
            public void onRewardedVideoCompleted(){}
        });
        loadRewardedVideoAd();
    }
    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRewardedVideoAd.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRewardedVideoAd.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRewardedVideoAd.destroy();
    }
    
}
/*don't forget to subscribe my YouTube channel for more Tutorial and mod*/
/*
https://youtube.com/channel/UC_lCMHEhEOFYgJL6fg1ZzQA */