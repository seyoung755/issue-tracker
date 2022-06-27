import { ReactNode, forwardRef, ElementType } from 'react';
import { CSSProp } from 'styled-components';

import { OverridableProps } from '@/utils/type';

import * as S from './style';

export type ButtonProps<T extends ElementType> = OverridableProps<
  T,
  {
    children: ReactNode;
    onClick: () => void;
    isSecondary?: boolean;
    disabled?: boolean;
    className?: string;
    customStyle?: CSSProp | null | undefined;
  }
>;

export const Button = forwardRef(
  <T extends ElementType = 'button'>({
    as,
    children,
    onClick,
    disabled = false,
    className,
    customStyle,
    isSecondary = false,
    ...restProps
  }: ButtonProps<T>) => {
    const Style = isSecondary ? S.Secondary : S.Button;
    return (
      <Style
        className={className}
        onClick={onClick}
        disabled={disabled}
        customStyle={customStyle}
        {...restProps}
      >
        {children}
      </Style>
    );
  },
);

export const TextButton = forwardRef(
  <T extends ElementType = 'button'>({
    as,
    children,
    onClick,
    disabled = false,
    className,
    customStyle,
    ...restProps
  }: ButtonProps<T>) => {
    return (
      <S.TextButton
        className={className}
        onClick={onClick}
        disabled={disabled}
        customStyle={customStyle}
        {...restProps}
      >
        {children}
      </S.TextButton>
    );
  },
);
