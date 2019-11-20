export interface IPagina<T, Z> {
    content: Array<T>;
    conteudo: Array<Z>;
    pageable: IPageable;
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    first: boolean;
    numberOfElements: number;
    offset: number;
    pageSize: number;
    pageNumber: number;
}

export interface IPageable {
    offset: number;
    pageSize: number;
    pageNumber: number;
}
