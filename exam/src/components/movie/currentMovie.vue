<template>
  <div style="height: 100%">
    <a-row style="padding-top: 5px">
      <a-col :span="6"></a-col>
      <a-col :span="12">
        <a-breadcrumb style="font-size: large">
          <a-breadcrumb-item>{{ movieName }}</a-breadcrumb-item>
          <a-breadcrumb-item>第{{currentNum}}集</a-breadcrumb-item>
        </a-breadcrumb>
      </a-col>
      <a-col :span="6"></a-col>
    </a-row>

    <a-row style="padding-top: 5px; height:60%">
      <a-col :span="6">
      </a-col>
      <a-col :span="12">
        <a-card>
          <video-player  class="video-player vjs-custom-skin"
                         ref="videoPlayer"
                         :playsinline="true"
                         :options="playerOptions"
          ></video-player>
        </a-card>
      </a-col>
      <a-col :span="6">
      </a-col>
    </a-row>
    <a-row style="padding-top: 30px " >
      <a-col :span="6" ></a-col>
      <a-col :span="12" >
        <a-space>
          <a-button v-for="num in nums" :type="num===currentNum?'primary':''" v-bind:key="num" @click="playCurrent(num)">{{num}}
          </a-button>
        </a-space>
      </a-col>
      <a-col :span="6"></a-col>
    </a-row>
  </div>
</template>
<script>
export default {
  name: 'currentMovie',
  data () {
    return {
      // 视频播放
      playerOptions: {
        playbackRates: [0.7, 1.0, 1.5, 2.0], //播放速度
        autoplay: false, //如果true,浏览器准备好时开始回放。
        muted: false, // 默认情况下将会消除任何音频。
        loop: false, // 导致视频一结束就重新开始。
        preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
        language: 'zh-CN',
        aspectRatio: '16:9', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
        sources: [{
          type: "",
          src:"" //url地址
        }],
        poster:require('/Users/gty/Desktop/src=http___ww1.sinaimg.cn_mw690_006VOOTJly1gye47cmofsj30yi0s5gpr.jpg&refer=http___www.sina.jpg'), //你的封面地址
        // width: document.documentElement.clientWidth,
        notSupportedMessage: '此视频暂无法播放，请稍后再试', //允许覆盖Video.js无法播放媒体源时显示的默认信息。
        controlBar: {
          timeDivider: true,
          durationDisplay: true,
          remainingTimeDisplay: false,
          fullscreenToggle: true  //全屏按钮
        }
      },
      nums:0,
      currentNum:1,
      movieName: ''
    }},
  created() {
    this.getMovieNum()
    this.playCurrent(this.currentNum)
  },
  methods:{
    playCurrent(num){
      this.currentNum = num
      this.playerOptions.sources[0].src = "http://localhost:8000/movie/currentMovie?path="+this.currentNum+".mp4"
      this.playerOptions.autoplay = true
      },
    getMovieNum(){
      this.$axios('/api/movie/movieNum/kaiduan').then(res=>{
        this.nums = res.data.data.num
        this.movieName = res.data.data.movieName
      })
    }
    }
}
</script>
