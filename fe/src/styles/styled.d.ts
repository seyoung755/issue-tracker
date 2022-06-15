import 'styled-components';

import { ColorTypes, FontSizeTypes, FontWeightTypes } from './theme';

declare module 'styled-components' {
  export interface DefaultTheme {
    color: ColorTypes;
    fontSize: FontSizeTypes;
    fontWeight: FontWeightTypes;
  }
}
