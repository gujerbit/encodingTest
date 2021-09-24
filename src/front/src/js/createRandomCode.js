export function createRandomCode() {
  let rndStr = '';
  let normalStr = [...Math.random().toString(36).slice(-9)]; //랜덤 문자 + 숫자를 전개식으로 배열로 만들어줌
  let specialChar = [ //특수 문자들
    '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '\\', '|', 
    '\'', '"', ';', ':', ',', '.', '<', '>', '/', '?', '`'
  ];

  for(let i = 0; i < normalStr.length; i++) {
    let rndNum = Math.floor(Math.random() * (specialChar.length - 1)); //0~특수문자 끝 인덱스까지
    rndStr += normalStr[i] + specialChar[rndNum]; //문자 + 특수문자로 조합
  }

  return rndStr;
}