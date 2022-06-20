import { ComponentPropsWithoutRef, ElementType } from 'react';

// T와 K를 합칠 때,  T 타입에 선언된 키가 K 타입에도 존재한다면 오버라이딩
// K 타입에서 T 타입이 가진 프로퍼티와 중복되는 녀석들을 제거한 후 인터섹션 타입으로 병합
export type Combine<T, K> = T & Omit<K, keyof T>;

// TODO: any vs unknown 타입 비교해보기
// K 타입 변수의 기본 타입을 unknown으로 정의함으로써 이 유틸 타입을 사용할 때는 반드시 K에 해당하는 타입인 컴포넌트의 프로퍼티를 입력하도록 강제
export type CombineElementProps<T extends ElementType, K = unknown> = Combine<
  K,
  ComponentPropsWithoutRef<T>
>;

// 특정 컴포넌트가 as 프로퍼티를 사용하여 HTML 엘리먼트 이름을 받고, 내부적으로 해당 엘리먼트의 속성 타입을 찾아 바인딩해주는 부분만 추상화
export type OverridableProps<T extends ElementType, K = unknown> = {
  as?: T;
} & CombineElementProps<T, K>;
