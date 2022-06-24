import { createGlobalStyle } from 'styled-components';

import { COLOR } from '@/styles/theme/color';
import { FONT } from '@/styles/theme/font';

import Normalize from './Normalize';

const GlobalStyle = createGlobalStyle`
${Normalize}
* {
  font-family: 'Noto Sans KR', sans-serif;
  box-sizing: border-box;
  margin: 0;
}
html {
    font: ${FONT.WEIGHT.REGULAR} 62.5%/1.5 ${FONT.FAMILY.BASE} 10px;
  }
  body {
    width: 100%;
    color: ${COLOR.BLACK};
    font: inherit;
    letter-spacing: -0.4px;
    font-size: 1.6rem;
    background: ${COLOR.GREY[600]};
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
