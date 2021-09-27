export { sendGet, sendPost, encodingGet, encodingPost, base64Get, base64Post };

function sendGet(value, store) {
  const req = new XMLHttpRequest();
  req.open('GET', `http://localhost:8090/none_encoding?param=${value}`, true);
  req.send();
  req.onreadystatechange = () => {
    if(req.readyState === XMLHttpRequest.DONE && req.status === 200) store.commit('getEncoding/setNone', req.responseText);
  }
}

function sendPost(value, store) {
  const req = new XMLHttpRequest();
  req.open('POST', 'http://localhost:8090/none_encoding', true);
  req.setRequestHeader('Content-type', 'text/plain');
  req.send(value);
  req.onreadystatechange = () => {
    if(req.readyState === XMLHttpRequest.DONE && req.status === 200) store.commit('postEncoding/setNone', req.responseText);
  }
}

function encodingGet(value, store) {
  const req = new XMLHttpRequest();
  req.open('GET', `http://localhost:8090/encoding?param=${encodeURIComponent(value)}`, true);
  req.send();
  req.onreadystatechange = () => {
    if(req.readyState === XMLHttpRequest.DONE && req.status === 200) store.commit('getEncoding/setEncoding', req.responseText);
  }
}

function encodingPost(value, store) {
  const req = new XMLHttpRequest();
  req.open('POST', 'http://localhost:8090/encoding', true);
  req.setRequestHeader('Content-type', 'text/plain');
  req.send(encodeURIComponent(value));
  req.onreadystatechange = () => {
    if(req.readyState === XMLHttpRequest.DONE && req.status === 200) store.commit('postEncoding/setEncoding', req.responseText);
  }
}

function base64Get(value, store) {
  const req = new XMLHttpRequest();
  req.open('GET', `http://localhost:8090/base64?param=${btoa(value)}`, true);
  req.send();
  req.onreadystatechange = () => {
    if(req.readyState === XMLHttpRequest.DONE && req.status === 200) store.commit('getEncoding/setBase64', req.responseText);
  }
}

function base64Post(value, store) {
  const req = new XMLHttpRequest();
  req.open('POST', 'http://localhost:8090/base64', true);
  req.setRequestHeader('Content-type', 'text/plain');
  req.send(btoa(value));
  req.onreadystatechange = () => {
    if(req.readyState === XMLHttpRequest.DONE && req.status === 200) store.commit('postEncoding/setBase64', req.responseText);
  }
}