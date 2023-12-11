import request from '@/utils/request'

export const fetchGet = (url, query) => {
  return request({
    url: url,
    method: 'get',
    params: query
  })
}
