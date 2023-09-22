
$(document).ready(function(){
    $.get("getSubstanceInfo").done(function(data) {

        var opiateStatisticsChartDomElement = document.getElementById('OpiateStatisticsChart');

        const jsondata = JSON.parse(data);
        createStackBar(opiateStatisticsChartDomElement, jsondata);
    });
});


function createStackBar(element, data) {
    var myChart = echarts.init(element);

    var option;

    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            top: '5%',
            left: 'center'
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: data.columns
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [

            {
                name: 'Current',
                type: 'bar',
                stack: 'Ad',
                emphasis: {
                    focus: 'series'
                },
                data: data.currentValues
            },
            {
                name: 'Historical',
                type: 'bar',
                stack: 'Ad',
                emphasis: {
                    focus: 'series'
                },
                data: data.historicValues
            }
        ]
    };

    if (option && typeof option === 'object') {
        myChart.setOption(option);
    }

    window.addEventListener('resize', myChart.resize);
}