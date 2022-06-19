import { ReactNode } from 'react';

import * as S from './style';

export interface ButtonProps {
  children: ReactNode;
  onClick: () => void;
  disabled: boolean;
  className?: string;
}

export default function Button({ children, onClick, disabled, className }: ButtonProps) {
  return (
    <S.Container className={className} onClick={onClick} disabled={disabled}>
      {children}
    </S.Container>
  );
}
