
$(document).ready(function(){
    $.get("getOutcomes").done(function(data) {

        var programOutcomeDomElement = document.getElementById('programOutcome');

        const jsondata = JSON.parse(data);
        createBar(programOutcomeDomElement, jsondata);
    });
});

function createBar(element, data) {
 var myChart = echarts.init(element);
  var option = {
    tooltip: {},
    legend: {
      data: ['outcome']
    },
    xAxis: {
      data: data.category
    },
    yAxis: {},
    series: [
      {
        name: 'outcome',
        type: 'bar',
        data: data.data
      }
    ]
  };

    if (option && typeof option === 'object') {
      myChart.setOption(option);
    }

    window.addEventListener('resize', myChart.resize);
}