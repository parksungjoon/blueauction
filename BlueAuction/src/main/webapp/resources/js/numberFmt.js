function setComma (number) {
    // 정규표현식 : (+- 존재하거나 존재 안함, 숫자가 1개 이상), (숫자가 3개씩 반복)
    var reg = /(^[+-]?\d+)(\d{3})/;

    // 스트링변환
    number += '';
    while (reg.test(number)) {
        // replace 정규표현식으로 3자리씩 콤마 처리
        number = number.replace(reg,'$1'+','+'$2');
    }

    return number;
}