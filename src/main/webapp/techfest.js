
function createGenderPie(data) {
// 基于准备好的dom，初始化echarts实例
var genderChart = echarts.init(document.getElementById('gender'));

var option = {
tooltip: {
  trigger: 'item'
},
legend: {
  top: '5%',
  left: 'center'
},
series: [
  {
    name: data.name,
    type: 'pie',
    radius: ['40%', '70%'],
    avoidLabelOverlap: false,
    itemStyle: {
      borderRadius: 10,
      borderColor: '#fff',
      borderWidth: 2
    },
    label: {
      show: false,
      position: 'center'
    },
    emphasis: {
      label: {
        show: true,
        fontSize: 40,
        fontWeight: 'bold'
      }
    },
    labelLine: {
      show: false
    },
    data: data.data
  }
]
};

  if (option && typeof option === 'object') {
    genderChart.setOption(option);
  }

  window.addEventListener('resize', genderChart.resize);
};


function createBar() {
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.getElementById('race'));

  // 指定图表的配置项和数据
  var option = {
    title: {
      text: 'ECharts 入门示例'
    },
    tooltip: {},
    legend: {
      data: ['销量']
    },
    xAxis: {
      data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
    },
    yAxis: {},
    series: [
      {
        name: '销量',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
      }
    ]
  };


    if (option && typeof option === 'object') {
      myChart.setOption(option);
    }

    window.addEventListener('resize', myChart.resize);
}


$("#genderBreakdown").on("click", function() {
//  var data = {
//    name: 'Gender breakdown',
//    data: [
//      { value: 10, name: 'Female' },
//      { value: 30, name: 'Male' }
//    ]
//};

 $.get("getGenderInfo").done(function(data) {

 const jsondata = JSON.parse(data);
   createGenderPie(jsondata);
 });

//console.log("hello");
//  createGenderPie(data);
});




//createBar();