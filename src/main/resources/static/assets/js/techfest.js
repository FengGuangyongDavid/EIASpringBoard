
function createPie(element, data) {
// 基于准备好的dom，初始化echarts实例
var genderChart = echarts.init(element);

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

$(document).ready(function(){

  $.get("getGenderInfo").done(function(data) {

    var genderElement = document.getElementById('gender');

    const genderData = JSON.parse(data);
    createPie(genderElement, genderData);

  });

  $.get("getRacialInfo").done(function(data) {

    var raceElement = document.getElementById('race');

    const jsondata = JSON.parse(data);
    createPie(raceElement, jsondata);
  });

  $.get("getAgeInfo").done(function(data) {

    var ageElement = document.getElementById('age');

    const jsondata = JSON.parse(data);
    createPie(ageElement, jsondata);
  });

});
