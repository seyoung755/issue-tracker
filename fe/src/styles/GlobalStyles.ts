import { createGlobalStyle } from 'styled-components';

import Normalize from './Normalize';

const GlobalStyle = createGlobalStyle`
${Normalize}
* {
  font-family: 'Noto Sans KR', sans-serif;
  box-sizing: border-box;
  margin: 0;
}
button,
input,
select,
textarea {
  background-color: transparent;
  border: 0;
  &:focus {
    outline: none;
    box-shadow: none;
  }
}
a,
button {
    text-decoration: none;
    color: inherit;
    cursor: pointer;
}
ul, li {
  padding: 0;
  list-style: none;
}
`;

export default GlobalStyle;
