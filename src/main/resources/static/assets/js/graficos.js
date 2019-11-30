var popCanvas = $("#popChart");
var oilCanvas = document.getElementById("oilChart");

var popCanvas = document.getElementById("popChart");
var popCanvas = document.getElementById("popChart").getContext("2d");

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;
Chart.defaults.global.defaultFontColor = 'blue';

var barChart = new Chart(popCanvas, {
  type: 'bar',
  data: {
    labels: ["Honda", "AKT", "Bajaj", "Kawasaki", "KTM", "Kymco", "Susuki", "Yamaha"],
    datasets: [{
      label: 'Population',
      data: [137930, 128193, 326620, 260580, 207353, 204924, 19063, 15782],
      backgroundColor: [
        'rgba(255, 99, 132, 0.6)',
        'rgba(54, 162, 235, 0.6)',
        'rgba(255, 206, 86, 0.6)',
        'rgba(75, 192, 192, 0.6)',
        'rgba(153, 102, 255, 0.6)',
        'rgba(255, 159, 64, 0.6)',
        'rgba(255, 99, 132, 0.6)',
        'rgba(54, 162, 235, 0.6)',
        'rgba(255, 206, 86, 0.6)'
      ]
    }]
  }
});

var oilData = {
    labels: [
        "Cascos",
        "Guantes",
        "Botas",
        "Rodilleras",
        "Coderas"
    ],
    datasets: [
        {
            data: [133.3, 86.2, 52.2, 51.2, 50.2],
            backgroundColor: [
                "#FF6384",
                "#63FF84",
                "#84FF63",
                "#8463FF",
                "#6384FF"
            ]
        }]
};

var pieChart = new Chart(oilCanvas, {
  type: 'pie',
  data: oilData
});


