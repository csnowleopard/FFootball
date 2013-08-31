'''
Created on Aug 29, 2013

@author: willg
'''

'''
API links:
- stats
http://api.sportsdatallc.org/nfl-[access_level][version]/[year]/[nfl_season]/[nfl_season_week]/[away_team]/[home_team]/statistics.[format]?api_key=[your_api_key]
- schedule
'''

import urllib2
import xml

''' universal variables '''
access_level = 't' # trial
version = '1' # or 1?
year = '2012'
nfl_season = 'REG'
file_format = 'xml'

domain = 'http://api.sportsdatallc.org'
api_key = '8h9rag9bvsk57nyxvawz2uv2'

''' get schedule xml '''
def get_schedule(base_url, access_level,version, year, nfl_season, file_format, api_key):
    return 'http://api.sportsdatallc.org/nfl-' + access_level + version + '/' + year + '/' + nfl_season + '/schedule.' + file_format + '?api_key=' + api_key

''' get stats per game '''

class data_url(object):
    def __init__(self, domain, access_level, version, file_format, api_key):
        self.base = domain + '/' + 'nfl-' + access_level + version
        self.suffix_xml = ''
        self.file_format = file_format
        self.suffix_api = '?api_key=' + api_key
    def set_url(self):
        self.url = self.base + self.suffix_xml + self.suffix_api
        
class test(data_url):
    pass

class stats_url(data_url):
    def __init__(self, year, nfl_season, nfl_season_week, away_team, home_team):
        self.suffix_xml = year + '/' + nfl_season + '/' + nfl_season_week + '/' + away_team + '/' + home_team + '/' + 'statistics.' + self.file_format

class schedule_url(data_url):
    def __init__(self, year, nfl_season):
        self.suffix_xml = year + '/' + nfl_season + '/schedule.' + file_format
        
def get_stats_url(base_url, access_level,version, year, nfl_season, nfl_season_week, away_team, home_team, file_format, api_key):
    suffix_xml = 'nfl-' + access_level + version + '/' + year + '/' + nfl_season + '/' + nfl_season_week + '/' + away_team + '/' + home_team + '/' + 'statistics.' + file_format
    suffix_api = '?api_key=' + api_key
    return base_url + '/' + suffix_xml + suffix_api

if __name__ == '__main__':
#     data_url1 = data_url(domain, access_level, version, file_format, api_key)
#     data_url1.set_url()
#     print data_url1.url
#     schedule_url1 = schedule_url(year, nfl_season)
#     schedule_url1.set_url()
#     print schedule_url1.url
#     test1 = test()
#     print test1
#     print test1.base
    seasons_list = ['2012']
    weeks_list = [str(i+1) for i in range(16)]
    teams = ['NYG','DAL','ATL','KC',]
    for year in seasons_list:
        for nfl_season_week in weeks_list:
            for away_team, home_team in away_home_combos_list:
                url_suffix_xml = get_xml_suffix_for_game(year, nfl_season_week, away_team, home_team)
                if file_exists(url_suffix_xml):
                    pass
                else:
                    url = get_url(domain, url_suffix_xml, api_key)
                    f = open(url_suffix_xml, 'w')
                    response = urllib2.urlopen(url)
                    f.write(response.read())
                    f.close()
                    

